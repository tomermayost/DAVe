import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';

export interface RoutePart {
    title: string;
    routePart: string;
    index?: number;
}

@Component({
    moduleId: module.id,
    selector: 'bread-crumbs',
    template: `
<a *ngIf="filteredRouteParts?.length > 0" [routerLink]="getRoute(0)">{{filteredRouteParts[0].title}}</a>
<span *ngIf="filteredRouteParts?.length > 1">: <a [routerLink]="getRoute(1)">{{filteredRouteParts[1].title}}</a></span>
<template [ngIf]="filteredRouteParts?.length > 2"> 
    <span *ngFor="let route of getAdditionalRoutes(); let i=index"> / <a [routerLink]="getRoute(i + 2)">{{filteredRouteParts[route].title}}</a></span>
</template>
`,
    styleUrls: ['common.component.css']
})
export class BreadCrumbsComponent implements OnChanges {

    @Input()
    public routeParts: RoutePart[];

    public filteredRouteParts: RoutePart[];

    public ngOnChanges(changes: SimpleChanges): void {
        this.filteredRouteParts = this.routeParts.filter((part: RoutePart, index: number) => {
            part.index = index;
            return part.title !== '*';
        });
    }

    public getRoute(index: number): string[] {
        index = this.filteredRouteParts[index].index;
        const items: string[] = [];
        for (let i = 0; i <= index; i++) {
            items.push(this.routeParts[i].routePart);
        }
        return items;
    }

    public getAdditionalRoutes(): number[] {
        const items: number[] = [];
        for (let i = 2; i < this.filteredRouteParts.length; i++) {
            if (this.filteredRouteParts[i].title !== '*') {
                items.push(i);
            }
        }
        return items;
    }
}