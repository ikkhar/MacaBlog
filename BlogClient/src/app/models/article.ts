import { Auteur } from './auteur';
import { Thematique } from './thematique';

export class Article {

  private _id: number;
  private _title: string;
  private _datePublication: Date;
  private _resume: string;
  private _contenent: string;
  private _auteurList: Auteur[];
  private _thematiques: Thematique[];
  private _paragraph: string;
  private _keywords: string[];


  constructor(data: any) {
    this._id = data.id;
    this._title = data.title;
    this._datePublication = data.datePublication;
    this._resume = data.resume;
    this._contenent = data.contenent;
    this._auteurList = data.auteurList;
    this._thematiques = data.thematiques;
    this._paragraph = data.paragraph;
    this._keywords = data.keywords;
  }

  /* GETTERS & SETTERS */
  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get datePublication(): Date {
    return this._datePublication;
  }

  set datePublication(value: Date) {
    this._datePublication = value;
  }

  get resume(): string {
    return this._resume;
  }

  set resume(value: string) {
    this._resume = value;
  }

  get contenent(): string {
    return this._contenent;
  }

  set contenent(value: string) {
    this._contenent = value;
  }

  get auteurList(): Auteur[] {
    return this._auteurList;
  }

  set auteurList(value: Auteur[]) {
    this._auteurList = value;
  }

  get thematiques(): Thematique[] {
    return this._thematiques;
  }

  set thematiques(value: Thematique[]) {
    this._thematiques = value;
  }

  get paragraph(): string {
    return this._paragraph;
  }

  set paragraph(value: string) {
    this._paragraph = value;
  }

  get keywords(): string[] {
    return this._keywords;
  }

  set keywords(value: string[]) {
    this._keywords = value;
  }
}
