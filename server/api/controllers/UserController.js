/**
 * UserController
 *
 * @description :: Server-side logic for managing Users
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
    /**
     * `UserController.index()`
     */
    index: function (req, res) {
	return res.json({
	    todo: 'index() is not implemented yet!'
	});
    },


    /**
     * `UserController.create()`
     */
    create: function(req, res){
	var params = req.params.all()
	User.create({
	    name: params.name,
	    password: params.password,
	    email: params.email
	}).exec(function createCB(err,user) {
	    if (err) return res.send(err);
	    token = jwToken.issue({id: user.id});
	    return res.json(200, {user: user, token: token});
	});
    },


    /**
     * `UserController.show()`
     */
    show: function (req, res) {
	return res.json({
	    todo: 'show() is not implemented yet!'
	});
    },


    /**
     * `UserController.edit()`
     */
    edit: function (req, res) {
	return res.json({
	    todo: 'edit() is not implemented yet!'
	});
    },


    /**
     * `UserController.delete()`
     */
    delete: function (req, res) {
	return res.json({
	    todo: 'delete() is not implemented yet!'
	});
    }
};
