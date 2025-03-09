package Disilon;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static int game_version = 1531;

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> WeaponDataMap = mapper.readValue(new File("data/Weapons.json"), Map.class);
            //Consider setting Weapons into 2 categories. One Handed and Two Handed. Then again, I guess a couple are main hand only and offhand only... Maybe just make the user not be stupid until we fix it.
            System.out.println(WeaponDataMap.get("BEECH_BOW"));
            Equipment testBow = new Equipment(WeaponDataMap.get("BEECH_BOW"));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //UserForm uf = new UserForm();
    }

}