Commandes pour démarrer le server et la node. 
Ouvrir PowerShell : maj + click droit --> ouvrir dans powershell 


Server : java -jar selenium-server-4.0.0-beta-1.jar hub

Node : java -jar selenium-server-4.0.0-beta-1.jar node --publish-events "tcp://localhost:4442" --subscribe-events "tcp://localhost:4443"