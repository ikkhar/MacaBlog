export class Topic {

  private _id: number;
  private _name: string;
  private _articles: [];
  private article: [];

  constructor(data: any) {
    this._id = data.id;
    this._name = data.name;
    this._articles = data.articles;
  }

  /* GETTERS & SETTERS */
  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get articles(): string {
    return this.articles;
  }

  set articles(value: string) {
    this.articles = value;
  }

}
