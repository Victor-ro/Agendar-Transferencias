import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { ScheduleFrontendComponent } from "./components/schedule-frontend/schedule-frontend.component";
import { ScheduleTableComponent } from "./components/schedule-table/schedule-table.component";


const routes: Routes = [
  { path: '', component: ScheduleFrontendComponent },
  { path: 'table', component: ScheduleTableComponent}
]

@NgModule({
    declarations: [],
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]

})

export class AppRoutingModule {}
