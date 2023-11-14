import { Component, OnInit } from '@angular/core';
import { Gatos } from 'src/app/compartidos/interfaces/gatos';

@Component({
  selector: 'app-httpcats',
  templateUrl: './httpcats.component.html',
  styleUrls: ['./httpcats.component.css']
})
export class HttpcatsComponent implements OnInit {
  panels : Gatos[];

  constructor(){
    this.panels = crearPanel()
  }

  ngOnInit(): void {}
}

function crearPanel() : Gatos[] {
  let gat : Gatos
  let paneles : Gatos[] = []
  for(let i = 0; i < codesHttp.length; i++){
    const code = codesHttp[i]
    gat = { 
      imagen: "https://http.cat/" + code + ".jpg",
      url : "https://http.cat/status/" + code 
    }
    paneles[i] = gat
  }

  return paneles
}

function filterErrors(errors: number[], exclusions: (number | [number, number])[]): number[] {
  return errors.filter((number) => {
      return exclusions.every((excluded) => {
          if (Array.isArray(excluded)) {
              const [start, end] = excluded
              return number < start || number > end
          } else {
              return number !== excluded
          }
      })
  })
}

const errors: number[] = Array.from({ length: 500 }, (_, i) => i + 100)
const exclusions: (number | [number, number])[] = [
  [104, 199],
  205, [208, 299],
  306, [309, 399],
  419, 427, 430, [432, 443], [445, 449], [452, 496],
  505, [512, 520], 524, [526, 529], [531, 598]
]

const codesHttp: number[] = filterErrors(errors, exclusions)