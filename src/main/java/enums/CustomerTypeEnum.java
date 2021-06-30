package enums;

public enum CustomerTypeEnum {

    REGULAR("Regular"),
    REWARD("Reward");

    private String descricao;

    CustomerTypeEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}