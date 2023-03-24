/**
 *
 */
package com.br.agente.redesocial.repostiory.model;

/**
 * @author Jorge Demetrio
 * @since 6 de abr de 2020 08:07:57
 * @version 1.0
 */
public enum GeneroEnum {
    MASCULINO("M"), FEMININO("f");

    private final String valor;

    /**
     *
     * @param pValor
     */
    private GeneroEnum(final String pValor) {
        this.valor = pValor;
    }

    public GeneroEnum parser(final String pValor) {
        GeneroEnum retorno = null;
        switch (pValor) {
        case "MASCULINO":
        case "M":
        case "m":
            retorno = MASCULINO;
            break;

        case "FEMININO":
        case "F":
        case "f":
            retorno = FEMININO;
            break;
        default:
            retorno = null;
            break;
        }
        return retorno;
    }

    @Override
    public String toString() {
        return valor;
    }

}
