package pl.allegier.controller.frontend.dto;

import pl.allegier.model.timestamp.ITimestamp;

import java.util.Date;

/**
 * Generic for DTO's to be timestamped
 */
public class TimeStampDto implements ITimestamp {

    /**
     * created timestamp
     */
    private Date created;

    /**
     * updated timestamp
     */
    private Date updated;

    @Override
    public final Date getCreated() {
        return created;
    }

    @Override
    public final Date getUpdated() {
        return updated;
    }

    @Override
    public final void setCreated(final Date aCreated) {
        this.created = aCreated;
    }

    @Override
    public final void setUpdated(final Date aUpdated) {
        this.updated = aUpdated;
    }
}
