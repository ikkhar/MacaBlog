export class Auteur {

  private _id: number;
  private _firstname: string;
  private _lastname: string;


  constructor(data: any) {
    this._id = data.id;
    this._firstname = data.name;
    this._lastname = data.articles;
  }

  /* GETTERS & SETTERS */
  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get firstname(): string {
    return this.firstname;
  }

  set firstname(value: string) {
    this.firstname = value;
  }

  get lastname(): string {
    return this.lastname;
  }

  set lastname(value: string) {
    this.lastname = value;
  }

}
