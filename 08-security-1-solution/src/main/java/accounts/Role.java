package accounts;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

public class Role implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 3690197650654049848L;
    private Long id;
    private String name;
    private String description;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Role() {
    }

    /**
     * Create a new instance and set the name.
     *
     * @param name name of the role.
     */
    public Role(final String name) {
        this.name = name;
    }
    
	public Role(Long id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
	}

    public Long getId() {
        return id;
    }

    /**
     * @return the name property (getAuthority required by Acegi's GrantedAuthority interface)
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    public String getAuthority() {
        return getName();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }

        final Role role = (Role) o;

        return !(name != null ? !name.equals(role.name) : role.name != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.name)
                .toString();
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(Object o) {
        return (equals(o) ? 0 : -1);
    }
}
