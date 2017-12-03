package pl.allegier.model.timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @ Class should be use as TimeStamp for Entities
 *
 */

@MappedSuperclass
public abstract class Timestamp implements ITimestamp{

    /**
    Field should be use us entity created timestamp
     */
    private Date created;
    /**
     Field should be use us entity updated timestamp
     */
    private Date updated;

    @CreationTimestamp
    @Column(updatable = false)
    @Override
    public final Date getCreated() {
        if (created == null)
        {
            return null;
        }

        return  new Date(created.getTime());
    }

    @UpdateTimestamp
    @Column
    @Override
    public final  Date getUpdated() {
        if (updated == null)
        {
            return null;
        }
        return new Date(updated.getTime());
    }

    @Override
    public final void setCreated(final Date created) {
        this.created = created == null ? new Date() : created ;
    }

    @Override
    public final void setUpdated(final Date updated) {
        this.updated = updated == null ? new Date() : updated;
    }

}
