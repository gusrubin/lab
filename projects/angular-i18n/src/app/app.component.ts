import { Component, } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { I18nService } from './i18n.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-i18n-app';
  selectedLang = 'en';

  constructor(public i18nService: I18nService) { }

  changeLanguage(lang: string) {
    this.i18nService.changeLanguage(lang);
    this.selectedLang = lang;
  }
}
