export class Pokemon{

    dexId: number;
    pokemonName: string;
    primaryType: string;
    secondaryType: string;
    ability: string;
    status: string
    currentHP : number;
    isHealthy: boolean;


    constructor(dexId:number, pokemonName: string, primaryType: string, secondaryType: string, ability: string, status: string, currentHP: number, isHealthy: boolean){
        this.dexId = dexId;
        this.pokemonName = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.ability = ability;
        this.status = status;
        this.currentHP = currentHP;
        this.isHealthy = isHealthy;

    }
}