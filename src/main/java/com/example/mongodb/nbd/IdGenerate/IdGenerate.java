package com.example.mongodb.nbd.IdGenerate;

import org.bson.types.ObjectId;

public  class IdGenerate {

    public IdGenerate() {
    }

    public String generateId(){
        return ObjectId.get().toHexString();
    }


}
