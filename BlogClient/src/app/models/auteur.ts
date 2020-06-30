export class Auteur {

  private _id : number;
  private _firstName: string;
  private _lastName: string;

  constructor(data: any){

    this._id= data.id;
    this._firstName= data.firstName;
    this._lastName= data.lastName;

  }

  /* GETTERS & SETTERS */
  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

}
