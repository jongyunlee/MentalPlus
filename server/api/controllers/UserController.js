/**
 * UserController
 *
 * @description :: Server-side logic for managing Users
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
    create: function(req, res){
	var params = req.params.all()
	User.create({
	    name: params.name,
	    password: params.password,
	    email: params.email
	}).exec(function createCB(err,user) {
	    if (err) return res.send(err);
	    token = jwToken.issue({id: user.id});
	    return res.json(200, {
		name: user.name,
		email: user.email,
		id: user.id,
		token: token
	    });
	});
    },
};
