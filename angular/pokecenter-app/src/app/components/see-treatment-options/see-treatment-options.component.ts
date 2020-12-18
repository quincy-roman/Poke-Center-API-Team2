import { TableService } from './../../services/table.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-see-treatment-options',
  templateUrl: './see-treatment-options.component.html',
  styleUrls: ['./see-treatment-options.component.css']
})
export class SeeTreatmentOptionsComponent implements OnInit {

  status: string;
  constructor(private tableService: TableService) { }

  ngOnInit(): void {
  }



  getTreatmentByStatus(value : any){
    const statusId = document.getElementById("status") as HTMLInputElement;

    let statId = Number(statusId.value)
    this.tableService.getTreatmentByStatus(statId)

  }
}

