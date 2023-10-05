class Triangulo {
    base: number;
    altura: number;

    constructor(base: number, altura:number){
        this.base = base;
        this.altura = altura;
    }

    calcularArea(): void {
        let area: number = (this.base * this.altura) / 2;
        console.log(`El area del triangulo es: ${area}`); 
    }

}

const triangulo = new Triangulo(22,2);
triangulo.calcularArea();