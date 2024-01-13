import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { ScheduleFrontendComponent } from "./components/schedule-frontend/schedule-frontend.component";


const routes: Routes = [
  { path: '', component: ScheduleFrontendComponent }
]

@NgModule({
    declarations: [],
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]

})

export class AppRoutingModule {}
