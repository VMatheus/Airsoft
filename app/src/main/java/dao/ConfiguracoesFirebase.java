package dao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfiguracoesFirebase {



    public static DatabaseReference referenceFirebase;
    public static StorageReference storageReference;
    public static FirebaseAuth auth;


    public static DatabaseReference getFirebase(){

        if(referenceFirebase == null){
            referenceFirebase = FirebaseDatabase.getInstance().getReference();

        }
        return  referenceFirebase;


    }
    public  static StorageReference getStorage(){
        if(storageReference == null){
            storageReference = FirebaseStorage.getInstance().getReference();
        }
        return storageReference;
    }


    public static  FirebaseAuth getFirebaseAutenticacao(){

        if(auth == null ){
            auth = FirebaseAuth.getInstance();
        }
        return auth;
    }



}
