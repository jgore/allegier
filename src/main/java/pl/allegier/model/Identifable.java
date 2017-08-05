package pl.allegier.model;

public interface Identifable<ID> {
    ID getId();
    void setId(ID id);
}
