sails generate model User name:string email:string password:string
sails generate controller User index create show edit delete

# - modify config/connections.js
# sailsMongoDBServer: {
# 	adapter: 'sails-mongo',
# 	host: 'localhost',
# 	port: 27017,
# 	database: 'MentalArithmeticDB'
# 	// user: 'username',
# 	// password: 'password'
# }

# - modify config/models.js
# connection: 'sailsMongoDBServer'

npm install sails-mongo --save

# - modify api/controller/UserController
#     create: function (req, res) {
# 	var params = req.params.all()
# 	User.create({name: params.name}.exec(function createCB(err, created)) {
# 	    return res.json({
# 		notice: 'Created user with name ' + created.name
# 	    });
# 	});
# },

# - modify User model
# var bcrypt = require('bcrypt');

# module.exports = {

#     attributes: {

# 	name : { type: 'string' },

# 	email : {
# 	    type: 'string',
# 	    required: true,
# 	    unique: true
# 	},

# 	password : {
# 	    type: 'string',
# 	    minLength: 6,
# 	    required: true
# 	},
# 	toJSON: function() {
# 	    var obj = this.toObject();
# 	    delete obj.password;
# 	    return obj;
# 	},
# 	beforeCreate: function(user, cb) {
# 	    bcrypt.getSalt(10, function(err, salt) {
# 		bycrypt.hash(user.password, salt, function(err, hash) {
# 		    if (err) {
# 			console.log(err);
# 			cb(err);
# 		    } else {
# 			user.password = hash;
# 			cb();
# 		    }
# 		});
# 	    });
# 	}
#     }
# };

sails generate controller auth
