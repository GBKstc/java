/* jshint indent: 2 */

module.exports = function(sequelize, DataTypes) {
  return sequelize.define('department', {
    id: {
      type: DataTypes.INTEGER(10),
      allowNull: false,
      primaryKey: true,
      autoIncrement: true
    },
    name: {
      type: DataTypes.STRING(20),
      allowNull: true
    }
  }, {
    tableName: 'department'
  });
};
