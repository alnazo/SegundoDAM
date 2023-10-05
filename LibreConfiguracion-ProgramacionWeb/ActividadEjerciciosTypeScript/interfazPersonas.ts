interface Personas {
    Nombre: string;
    Apellidos: string;
    Edad: number;
    
    MayorDeEdad(): boolean;
}

class Persona implements Personas {
    Nombre: string;
    Apellidos: string;
    Edad: number;

    constructor(nom: string, ape: string, edad: number){
        this.Nombre = nom;
        this.Apellidos = ape;
        this.Edad = edad;
    }

    MayorDeEdad(): boolean{
        let mayor: boolean = false;
        if (this.Edad >= 18) {
            mayor = true;
        }
        return mayor;
    }
}

let persona :Persona = new Persona("Pedro", "Martinez", 18);
console.log(`${persona.Nombre} tiene ${persona.Edad} y ${persona.MayorDeEdad() ? "es mayor" : "es menor"} de edad`);