package Model;

public class Builder {
    String name, number, qualification;

    public Builder name(String name) {
        this.name = name;
        return this;
    }
    public Builder number(String number) {
        this.number = number;
        return this;
    }
    public Builder qualification(String qualification) {
        this.qualification = qualification;
        return this;
    }

    public  Builder build(){
        return this;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
