package one.digitalinnovation.gof.resources.httpclients.viacep;

import one.digitalinnovation.gof.domain.models.Endereco;
import one.digitalinnovation.gof.resources.httpclients.viacep.response.EnderecoResponse;
import org.springframework.beans.BeanUtils;

public class ViaCepAdapters {

    private ViaCepAdapters() {
    }

    public static Endereco converToEndereco(EnderecoResponse enderecoResponse) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoResponse, endereco);
        return endereco;
    }
}
