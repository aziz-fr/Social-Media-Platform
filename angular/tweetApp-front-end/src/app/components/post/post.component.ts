import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationRequest } from'src/app/models/AuthenticationRequest';
import { DataService } from 'src/app/services/data.service';
import { ServiceResponse } from'src/app/models/ServiceResponse';
import { ITweet } from 'src/app/models/tweet.model';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent 
{

  constructor(private formBuilder: FormBuilder, private router: Router, private dataService: DataService){}

  postForm = this.formBuilder.group({
    content: ['', Validators.maxLength(144)],
    date: [new Date()],
    userId:[localStorage.getItem('id')]
  });

  get content()
  {
    return this.postForm.get('content');
  }

  get date()
  {
    return this.postForm.get('date');
  }
  get userId()
  {
    return this.postForm.get('userId');
  }

 
  onPostHandler()
  {
    console.log(this.postForm.value);
    console.log(localStorage.getItem('id'));

    this.dataService.postTweet(localStorage.getItem('id'), this.postForm.value).subscribe(
      (response: any) =>
        {
          if(response)
            {
              this.router.navigate(['/profile']);
            }
        }
    )
  }

}
