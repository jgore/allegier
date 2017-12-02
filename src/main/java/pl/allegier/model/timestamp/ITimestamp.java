package pl.allegier.model.timestamp;

import java.util.Date;

/**
 * @ Interface for creating TimeStamps ( for example in Entities and DTOs )
 *
 */

public interface ITimestamp {

    /**
     *
     * @return created Timestamp
     */

    Date getCreated();

    /**
     *
     * @return updated Timestamp
     */

    Date getUpdated();

    /**
     *
     * @param created  to be persisted
     */
    void setCreated(Date created);

    /**
     *
     * @param updated to be persisted
     */

    void setUpdated(Date updated);

}
