export interface ScheduledTransfer {
  id?: number;
  originAccount: string;
  destinationAccount: string;
  transferAmount: number;
  fee?: number;
  transferDate: Date;
  scheduledDate?: Date;
}
