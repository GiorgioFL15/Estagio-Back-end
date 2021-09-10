package com.example.demo;

import java.util.ArrayList;
import java.util.UUID;

import org.bson.BSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	private ArrayList<BSONObject> listaCarros = new ArrayList<BSONObject>();
	
	private MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	
	private DB db = mongoClient.getDB("CarrosDataBase");
	
	private DBCollection dbCollection = db.getCollection("carros");

	
	@GetMapping
	public ArrayList<BSONObject> getListCarro() {
		DBCursor cursor = dbCollection.find();
	
		while(cursor.hasNext()){
			listaCarros.add(cursor.next());
		}
		return listaCarros;
	}
	
	@PostMapping
	public void criarCarro(@RequestBody Carro carro) {
		String uniqueID = UUID.randomUUID().toString();
        carro.setId(uniqueID);
        DBObject query = BasicDBObjectBuilder.start().add("_id", carro.getId()).get();
        DBCursor cursor = dbCollection.find(query);
        if (!cursor.hasNext()) {
            DBObject dbCarro = createDBObject(carro);
            dbCollection.insert(dbCarro);
        }
	}
	
	@PutMapping("/update")
	public void atualizarCarro(@RequestBody Carro novoCarro) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", novoCarro.getId()).get();
		DBObject dbNovoCarro = createDBObject(novoCarro);
		dbCollection.update(query, dbNovoCarro);
	}
	

	@DeleteMapping("/delete")
	public void deletarCarro(@RequestParam int id) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", id).get();
		dbCollection.remove(query);
			
	}
	
	private static DBObject createDBObject(Carro carro) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("_id", carro.getId());
		docBuilder.append("nome", carro.getNome());
		docBuilder.append("modelo", carro.getModelo());
		docBuilder.append("dataFabricacao", carro.getData());
		docBuilder.append("preco", carro.getPreco());
		docBuilder.append("cor", carro.getCor());
		docBuilder.append("marca", carro.getMarca());
		return docBuilder.get();
	}
}


