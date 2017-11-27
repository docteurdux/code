// $ANTLR : "hql-sql.g" -> "HqlSqlBaseWalker.java"$

package org.hibernate.hql.internal.antlr;

import java.util.Stack;

import org.hibernate.internal.CoreMessageLogger;
import org.jboss.logging.Logger;

public interface HqlSqlTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int ALL = 4;
	int ANY = 5;
	int AND = 6;
	int AS = 7;
	int ASCENDING = 8;
	int AVG = 9;
	int BETWEEN = 10;
	int CLASS = 11;
	int COUNT = 12;
	int DELETE = 13;
	int DESCENDING = 14;
	int DOT = 15;
	int DISTINCT = 16;
	int ELEMENTS = 17;
	int ESCAPE = 18;
	int EXISTS = 19;
	int FALSE = 20;
	int FETCH = 21;
	int FROM = 22;
	int FULL = 23;
	int GROUP = 24;
	int HAVING = 25;
	int IN = 26;
	int INDICES = 27;
	int INNER = 28;
	int INSERT = 29;
	int INTO = 30;
	int IS = 31;
	int JOIN = 32;
	int LEFT = 33;
	int LIKE = 34;
	int MAX = 35;
	int MIN = 36;
	int NEW = 37;
	int NOT = 38;
	int NULL = 39;
	int OR = 40;
	int ORDER = 41;
	int OUTER = 42;
	int PROPERTIES = 43;
	int RIGHT = 44;
	int SELECT = 45;
	int SET = 46;
	int SOME = 47;
	int SUM = 48;
	int TRUE = 49;
	int UPDATE = 50;
	int VERSIONED = 51;
	int WHERE = 52;
	int NULLS = 53;
	int FIRST = 54;
	int LAST = 55;
	int CASE = 56;
	int END = 57;
	int ELSE = 58;
	int THEN = 59;
	int WHEN = 60;
	int ON = 61;
	int WITH = 62;
	int BOTH = 63;
	int EMPTY = 64;
	int LEADING = 65;
	int MEMBER = 66;
	int OBJECT = 67;
	int OF = 68;
	int TRAILING = 69;
	int KEY = 70;
	int VALUE = 71;
	int ENTRY = 72;
	int AGGREGATE = 73;
	int ALIAS = 74;
	int CONSTRUCTOR = 75;
	int CASE2 = 76;
	int CAST = 77;
	int EXPR_LIST = 78;
	int FILTER_ENTITY = 79;
	int IN_LIST = 80;
	int INDEX_OP = 81;
	int IS_NOT_NULL = 82;
	int IS_NULL = 83;
	int METHOD_CALL = 84;
	int NOT_BETWEEN = 85;
	int NOT_IN = 86;
	int NOT_LIKE = 87;
	int ORDER_ELEMENT = 88;
	int QUERY = 89;
	int RANGE = 90;
	int ROW_STAR = 91;
	int SELECT_FROM = 92;
	int UNARY_MINUS = 93;
	int UNARY_PLUS = 94;
	int VECTOR_EXPR = 95;
	int WEIRD_IDENT = 96;
	int CONSTANT = 97;
	int NUM_DOUBLE = 98;
	int NUM_FLOAT = 99;
	int NUM_LONG = 100;
	int NUM_BIG_INTEGER = 101;
	int NUM_BIG_DECIMAL = 102;
	int JAVA_CONSTANT = 103;
	int COMMA = 104;
	int EQ = 105;
	int OPEN = 106;
	int CLOSE = 107;
	int IDENT = 108;
	int LITERAL_by = 109;
	int LITERAL_ascending = 110;
	int LITERAL_descending = 111;
	int NE = 112;
	int SQL_NE = 113;
	int LT = 114;
	int GT = 115;
	int LE = 116;
	int GE = 117;
	int CONCAT = 118;
	int PLUS = 119;
	int MINUS = 120;
	int STAR = 121;
	int DIV = 122;
	int MOD = 123;
	int OPEN_BRACKET = 124;
	int CLOSE_BRACKET = 125;
	int QUOTED_STRING = 126;
	int COLON = 127;
	int PARAM = 128;
	int NUM_INT = 129;
	int ID_START_LETTER = 130;
	int ID_LETTER = 131;
	int ESCqs = 132;
	int WS = 133;
	int HEX_DIGIT = 134;
	int EXPONENT = 135;
	int FLOAT_SUFFIX = 136;
	int FROM_FRAGMENT = 137;
	int IMPLIED_FROM = 138;
	int JOIN_FRAGMENT = 139;
	int ENTITY_JOIN = 140;
	int SELECT_CLAUSE = 141;
	int LEFT_OUTER = 142;
	int RIGHT_OUTER = 143;
	int ALIAS_REF = 144;
	int PROPERTY_REF = 145;
	int SQL_TOKEN = 146;
	int SELECT_COLUMNS = 147;
	int SELECT_EXPR = 148;
	int THETA_JOINS = 149;
	int FILTERS = 150;
	int METHOD_NAME = 151;
	int NAMED_PARAM = 152;
	int BOGUS = 153;
	int RESULT_VARIABLE_REF = 154;
}
