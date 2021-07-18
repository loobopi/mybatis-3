/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

/**
 * @author Clinton Begin
 */

/**
 * 执行器类型
 * SIMPLE：默认执行器，根据对应的Sql直接执行，不会做一些额外的操作；
 * REUSE:可重用执行器，重用对象是Statement（即该执行器会缓存同一个sql的statement，省区statement的重新创建，优化性能（即会重用预处理语句））
 * BATCH：BATCH执行器会重用预处理语句，并执行批量更新。
 *
 * 2、executor-type执行效果
 * executor-type值为SIMPLE、REUSE，可通过insert、update、delete方法的返回值判断sql是否执行成功，返回非0表示执行sql成功的条数，返回0表示sql执行失败
 * executor-type值为BATCH，insert、update、delete方法返回值一直会是负数-2147482646，在该模式下insert、update、delete返回值将无任何意义，不能作为判断sql执行成功的判断依据
 *
 */
public enum ExecutorType {
  SIMPLE, REUSE, BATCH
}
