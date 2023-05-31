package Tests;
class Distance{ 
    /**
     * @param args
     */
    public static void main(String[] args) {
        

        final int tab [] = {1,3,6,7,3,9};
        int aux = tab[0] - tab[1];
        if(aux < 0){
            aux = aux * -1;
        }
        int distance = 0;
        for(int i= 0; i<tab.length-1; i++){
            int suivant = tab[i+1];
            int precedent = tab[i];
           distance = precedent - suivant;
           if(distance < 0){
            distance = distance * -1;
          }

          if (distance < aux){
            aux = distance;
          }

        }

      
        
    }
}
