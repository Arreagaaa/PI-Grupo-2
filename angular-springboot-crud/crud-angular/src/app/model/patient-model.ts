// modelo de datos para el paciente
// angular-springboot-crud/crud-angular/src/app/model/patient-model.ts
export class PatientModel {
  patientID: number = 0;
  name: string = '';
  lastname: string = '';
  identificationNumber: string = '';
  documentType: string = '';
  birthDate: Date = new Date();
  gender: string = '';
  address: string = '';
  department: string = '';
  municipality: string = '';
  phoneNumber: string = '';
  email: string = '';
  patientType: 'VIP' | 'Standard' = 'Standard';
}
