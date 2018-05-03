public class PermissaoNegadaException extends RuntimeException {
    public PermissaoNegadaException() {
        super("Voce nao tem permissao para acessar esse conteudo");
    }
}
