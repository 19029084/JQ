package com.jq.entity;

    import javax.persistence.*;
    import java.util.Objects;
    import java.util.Set;
import lombok.Data;


@Data
@Entity
@Table(name = "sys_role", schema = "JQ", catalog = "")
public class JQRole
{
	
	private String name;
	private String nameCN;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
		
	@Basic
        @Column(name = "name")
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        
        @Basic
        @Column(name = "name_cn")
        public String getNameCN() {
            return nameCN;
        }
        public void setNameCN(String name_cn) {
            this.nameCN = name_cn;
        }


}
