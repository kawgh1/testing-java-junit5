package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

/**
 * created by kw on 12/3/2020 @ 10:10 PM
 */
public class ModelMapImpl implements Model{

    // since this is not a full Spring setup, this is a fake map implementation of a Spring Model for testing purposes
    // so adding things to the map is supposed to mimic adding attributes to the model like model.addAttribute("cats", cats);

    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {

        map.put(key, o);

    }

    @Override
    public void addAttribute(Object o) {
//        do nothing ....

    }


    public Map<String, Object> getMap() {
        return map;
    }
}
