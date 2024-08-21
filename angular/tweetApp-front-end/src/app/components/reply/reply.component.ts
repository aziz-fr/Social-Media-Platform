import { Component } from '@angular/core';

@Component({
  selector: 'app-reply',
  templateUrl: './reply.component.html',
  styleUrls: ['./reply.component.css']
})
export class ReplyComponent {

  showReplySection: boolean = false;
  replyText: string = '';
  userID = localStorage.getItem('id');

  toggleReply()
  {
   this.showReplySection = !this.showReplySection;
  }

  submitReply()
  {

  }
  

}
