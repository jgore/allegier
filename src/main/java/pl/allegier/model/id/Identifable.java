package pl.allegier.model.id;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
@MappedSuperclass
public class Identifable implements IIdentifable<UUID> {

    /**
     * id to be persisted to identity entity
     */
    @Id
    @GeneratedValue
    private UUID id;

    @Override
    public final UUID getId() {
        return id;
    }

    @Override
    public final void setId(final UUID uuid) {
        this.id = uuid;
    }
}
