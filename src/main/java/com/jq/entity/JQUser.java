    package com.jq.entity;
    
    import com.jq.entity.JQRole;
    import javax.persistence.*;
    import java.util.Objects;
    import java.util.List;
    
    import lombok.Data; 

    //@Entity
    //@Table(name = "sys_user", schema = "JQ", catalog = "")
    @Data
    public class JQUser {
        private String username;
        //private String email;
        private String password;
        private String identity;
        //private Byte activated;
        //private String activationkey;
        //private String resetpasswordkey;
        private int id;
        protected List<JQRole> roles;
        //@Basic
        //@Column(name = "username")
        //public String getUsername() {
        //    return username;
        //}
        //public void setUsername(String username) {
        //    this.username = username;
        //}
        //@Basic
        //@Column(name = "email")
        //public String getEmail() {
        //    return email;
        //}
        //public void setEmail(String email) {
        //    this.email = email;
        //}
        //@Basic
        //@Column(name = "password")
        //public String getPassword() {
        //    return password;
        //}
        //public void setPassword(String password) {
        //    this.password = password;
        //}
        //@Basic
        //@Column(name = "activated")
        //public Byte getActivated() {
        //    return activated;
        //}
        //public void setActivated(Byte activated) {
        //    this.activated = activated;
        //}
        //@Basic
        //@Column(name = "activationkey")
        //public String getActivationkey() {
        //    return activationkey;
        //}
        //public void setActivationkey(String activationkey) {
        //    this.activationkey = activationkey;
        //}
        //@Basic
        //@Column(name = "resetpasswordkey")
        //public String getResetpasswordkey() {
        //    return resetpasswordkey;
        //}
        //public void setResetpasswordkey(String resetpasswordkey) {
        //    this.resetpasswordkey = resetpasswordkey;
        //}
        //@Id
        //@Column(name = "id")
        //public int getId() {
        //    return id;
        //}
        //public void setId(int id) {
        //    this.id = id;
        //}
        //@ManyToMany
        //@JoinTable(
        //        name="sys_user_role",
        //        joinColumns = @JoinColumn(name="user_id"),
        //        inverseJoinColumns = @JoinColumn(name="role_id")
        //)
        //public List<JQRole> getRoles() {
        //    return roles;
        //}
        //public void setRoles(List<JQRole> roles) {
        //    this.roles = roles;
        //}
        //@Override
        //public boolean equals(Object o) {
        //    if (this == o) return true;
        //    if (o == null || getClass() != o.getClass()) return false;
        //    JQUser that = (JQUser) o;
        //    return Objects.equals(username, that.username) &&
        //            Objects.equals(email, that.email) &&
        //            Objects.equals(password, that.password) &&
        //            Objects.equals(activated, that.activated) &&
        //            Objects.equals(activationkey, that.activationkey) &&
        //            Objects.equals(resetpasswordkey, that.resetpasswordkey) &&
        //            Objects.equals(id, that.id);
        //}
        //@Override
        //public int hashCode() {
        //    return Objects.hash(username, email, password, activated, activationkey, resetpasswordkey, id);
        //}
    }
