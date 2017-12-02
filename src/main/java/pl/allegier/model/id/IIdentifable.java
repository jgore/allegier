package pl.allegier.model.id;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 *
 * @param <ID> type of ID to be persisted
 */

public interface IIdentifable<ID> {
    /**
     * @return persisted ID
     */
    ID getId();

    /**
     * @param id to be persisted ID
     */
    void setId(final ID id);
}
