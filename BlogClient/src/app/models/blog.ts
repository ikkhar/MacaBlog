export class Blog {

  private _id: number;
  private _titre: string;
  private _date: Date;
  private _paragraph: string;
  private _keywords: string[];

  constructor(data: any) {
    this._id = data.id;
    this._titre = data.titre;
    this._date = data.date;
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

  get titre(): string {
    return this._titre;
  }

  set titre(value: string) {
    this._titre = value;
  }

  get date(): Date {
    return this._date;
  }

  set date(value: Date) {
    this._date = value;
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
