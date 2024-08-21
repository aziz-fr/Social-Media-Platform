import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { LoginComponent } from "./pages/login/login.component"
import { TweetComponent } from "./components/tweet/tweet.component"
import { RegisterComponent } from "./pages/register/register.component"
import { TweetsPageComponent } from "./pages/tweets-page/tweets-page.component"
import { ProfilePageComponent } from "./pages/profile-page/profile-page.component"
import { UsersPageComponent } from "./pages/users-page/users-page.component"
import { ForgotPasswordComponent } from "./pages/forgot-password/forgot-password.component"
import { AuthGuard } from "./guard/auth.guard"


const routes: Routes = [
    {path: '', redirectTo: 'login', pathMatch: 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'tweets', component: TweetsPageComponent, canActivate: [AuthGuard]},
    {path: 'tweets/:id', component: TweetComponent, canActivate: [AuthGuard]},
    {path: 'profile', component: ProfilePageComponent,canActivate: [AuthGuard]},
    {path: 'users', component: UsersPageComponent,canActivate: [AuthGuard]},
    {path: 'setpassword', component: ForgotPasswordComponent }
    
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule
 {

  }