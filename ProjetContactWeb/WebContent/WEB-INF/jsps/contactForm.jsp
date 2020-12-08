
<html>
    <head>
    	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    	 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>
            Contact
        </title>
    </head>
    <body>
	    <header>
	    	<nav class="light-blue accent-4">
	    		<div class="nav-wrapper">
	      			<a href="index.html" class="brand-logo left">TD6</a>
	      			<ul id="nav-mobile" class="right hide-on-med-and-down">
	        			<li><a href="addContactFormServlet">Nouveau Contact</a></li>
	        			<li><a href="ListContactServlet">Liste Contacts</a></li>
	      			</ul>
	    		</div>
	  		</nav>
    	</header>
        <h1>Nouveau Contact </h1>
        <div class="row">
	        <form class="col s12" method="post" action="AddContactExecuteServlet">
		        <div class="row">
		        	<div class="input-field col s6">
		        		<input type="text" name="contact.prenom"/>
		        		<label>Prénom</label>
		        	</div>
		        	<div class="input-field col s6">
		        		<input type="text" name="contact.nom"/>
		        		<label>Nom</label>
		        	</div>
		        </div>
		        <div class="row">
		        	<div class="input-field col s12">
		        		<input type="text" name="contact.adresse"/>
		        		<label>Adresse</label>
		        	</div>
		        </div>
		        <div class="row">
		        	<div class="input-field col s6">
		        		<input type="text" name="contact.codePostal"/>
		        		<label>Code Postal</label>
		        	</div>
		        	<div class="input-field col s6">
		        		<input type="text" name="contact.ville"/>
		        		<label>Ville</label>
		        	</div>
		        </div>
		        <div class="row">
		        	<div class="input-field col s6">
		        		<input type="text" name="contact.mobile"/>
		        		<label>Portable</label>
		        	</div>
		        	<div class="input-field col s6">
		        		<input type="text" name="contact.telephone"/>
		        		<label>Fixe</label>
		        	</div>
		        </div>
				<div class="row">
					<div class="input-field col s6">
						<button class="btn waves-effect waves-light light-blue accent-4" type="submit">Submit
							<i class="material-icons right">send</i>
						</button>
					</div>
				</div>
	        </form>
        </div>
    </body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</html>
