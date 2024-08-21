import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ScrollbarComponent } from './scrollbar/scrollbar.component';
import { LoginComponent } from './pages/login/login.component';
import { TweetComponent } from './components/tweet/tweet.component';
import { RegisterComponent } from './pages/register/register.component';
import { TweetsPageComponent } from './pages/tweets-page/tweets-page.component';
import { PostComponent } from './components/post/post.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { TweetsByUserComponent } from './components/tweets-by-user/tweets-by-user.component';
import { UsersComponent } from './components/users/users.component';
import { UsersPageComponent } from './pages/users-page/users-page.component';
import { ForgotPasswordComponent } from './pages/forgot-password/forgot-password.component';
import { ReplyComponent } from './components/reply/reply.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ScrollbarComponent,
    LoginComponent,
    TweetComponent,
    RegisterComponent,
    TweetsPageComponent,
    PostComponent,
    ProfilePageComponent,
    TweetsByUserComponent,
    UsersComponent,
    UsersPageComponent,
    ForgotPasswordComponent,
    ReplyComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
