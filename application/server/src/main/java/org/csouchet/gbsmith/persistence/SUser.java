/**
 * Copyright Céline Souchet
 */
package org.csouchet.gbsmith.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Souchet Celine
 */
@Entity
@Table(name = "user")
public class SUser implements Serializable {

	private static final long serialVersionUID = -7003561620021490950L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String firstname;

	@Column
	private String lastname;

	public SUser() {
		super();
	}

	public SUser(final long id, final String firstname, final String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(final String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SUser other = (SUser) obj;
		if (firstname == null) {
			if (other.firstname != null) {
				return false;
			}
		} else if (!firstname.equals(other.firstname)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastname == null) {
			if (other.lastname != null) {
				return false;
			}
		} else if (!lastname.equals(other.lastname)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SUser [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
