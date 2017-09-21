package whatsapp.cursoandroid.com.instagram.activity.helper;

import java.util.HashMap;

/**
 * Created by leodegeus on 19/09/17.
 */

public class ParseError {

    private HashMap<Integer,String > erros;

    public ParseError() {
        this.erros = new HashMap<>();
        this.erros.put(202,"Usuário já existe");
    }

    public String getErro(int codErro) {
        String erroDescription = erros.get(codErro);
        return erroDescription;
    }
}
