package com.example.p15_alexandervillalobos;
import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    private String nombre;
    private int edad;
    private String sexo;
    private boolean nacionalidad;
    private String gradoAcademico;

    public Persona(String nombre, int edad, String sexo, boolean nacionalidad, String gradoAcademico) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.gradoAcademico = gradoAcademico;
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        edad = in.readInt();
        sexo = in.readString();
        nacionalidad = in.readByte() != 0;
        gradoAcademico = in.readString();
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean isNacionalidad() {
        return nacionalidad;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(edad);
        dest.writeString(sexo);
        dest.writeByte((byte) (nacionalidad ? 1 : 0));
        dest.writeString(gradoAcademico);
    }
}

