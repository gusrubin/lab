import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class I18nService {

  private translations: { [key: string]: any } = {};
  private currentLang = new BehaviorSubject<string>('en');

  constructor() {
    this.loadTranslations('en');
  }

  private loadTranslations(lang: string) {
    fetch(`assets/i18n/${lang}.json`)
      .then((res) => res.json())
      .then((data) => {
        this.translations = data;
        this.currentLang.next(lang);
      });
  }

  public getTranslation(key: string): string {
    return this.translations[key] || key;
  }

  public changeLanguage(lang: string) {
    this.loadTranslations(lang);
  }

  public getCurrentLang() {
    return this.currentLang.asObservable();
  }
}
